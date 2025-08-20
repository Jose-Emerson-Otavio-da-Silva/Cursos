using Microsoft.AspNetCore.Components.Authorization;
using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;
using Gestao.Components;
using Gestao.Components.Account;
using Gestao.Data;
using Gestao.Domain;
using System.Net.Mail;
using Gestao.Libraries.Mail;
using Gestao.Data.Repositories;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddRazorComponents()
    .AddInteractiveServerComponents()
    .AddInteractiveWebAssemblyComponents();

#region Config of Authentication
builder.Services.AddCascadingAuthenticationState();
builder.Services.AddScoped<IdentityUserAccessor>();
builder.Services.AddScoped<IdentityRedirectManager>();
builder.Services.AddScoped<AuthenticationStateProvider, PersistingRevalidatingAuthenticationStateProvider>();

builder.Services.AddAuthentication(options =>
    {
        options.DefaultScheme = IdentityConstants.ApplicationScheme;
        options.DefaultSignInScheme = IdentityConstants.ExternalScheme;
    })
    //Autenticacao do Google
    .AddGoogle(options =>
   {
       options.ClientId = builder.Configuration.GetValue<String>("OAuth:Google:ClientId")!;
       options.ClientSecret = builder.Configuration.GetValue<String>("OAuth:Google:ClientSecret")!;
   })
    //------------------------------------------------------------------------------------------------
    //Autenticacao do Facebook
    .AddFacebook(options =>
   {
       options.ClientId = builder.Configuration.GetValue<String>("OAuth:Facebook:ClientId")!;
       options.ClientSecret = builder.Configuration.GetValue<String>("OAuth:Facebook:ClientSecret")!;
   })
    //------------------------------------------------------------------------------------------------
    //Autenticacao do Microsoft
    .AddMicrosoftAccount(options =>
   {
       options.ClientId = builder.Configuration.GetValue<String>("OAuth:Microsoft:ClientId")!;
       options.ClientSecret = builder.Configuration.GetValue<String>("OAuth:Microsoft:ClientSecret")!;
   })
    //------------------------------------------------------------------------------------------------
    .AddIdentityCookies();
#endregion

#region Config of Entity Framework
var connectionString = builder.Configuration.GetConnectionString("DefaultConnection") ?? throw new InvalidOperationException("Connection string 'DefaultConnection' not found.");
builder.Services.AddDbContext<ApplicationDbContext>(options =>
    options.UseSqlServer(connectionString));
builder.Services.AddDatabaseDeveloperPageExceptionFilter();

builder.Services.AddIdentityCore<ApplicationUser>(options => options.SignIn.RequireConfirmedAccount = true)
    .AddEntityFrameworkStores<ApplicationDbContext>()
    .AddSignInManager()
    .AddDefaultTokenProviders();
#endregion

#region Dependency Injection
builder.Services.AddSingleton<SmtpClient>(options =>
{
    var smtp = new SmtpClient();
    smtp.Host = builder.Configuration.GetValue<string>("EmailSender:Server")!;
    smtp.Port = builder.Configuration.GetValue<int>("EmailSender:Port");
    smtp.EnableSsl = builder.Configuration.GetValue<bool>("EmailSender:SSL");

    smtp.Credentials = new System.Net.NetworkCredential(
        builder.Configuration.GetValue<string>("EmailSender:User")!,
        builder.Configuration.GetValue<string>("EmailSender:Password")!);
    return smtp;
});
builder.Services.AddSingleton<IEmailSender<ApplicationUser>, EmailSender>();

builder.Services.AddScoped<IAccountRepository, AccountRepository>();
builder.Services.AddScoped<ICategoryRepository, CategoryRepository>();
builder.Services.AddScoped<ICompanyRepository, CompanyRepository>();
builder.Services.AddScoped<IDocumentRepository, DocumentRepository>();
builder.Services.AddScoped<IFinancialTransactionRepository, FinancialTransactionRepository>();
#endregion

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseWebAssemblyDebugging();
    app.UseMigrationsEndPoint();
}
else
{
    app.UseExceptionHandler("/Error", createScopeForErrors: true);
    // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
    app.UseHsts();
}

app.UseHttpsRedirection();

app.UseStaticFiles();
app.UseAntiforgery();

app.MapRazorComponents<App>()
    .AddInteractiveServerRenderMode()
    .AddInteractiveWebAssemblyRenderMode()
    .AddAdditionalAssemblies(typeof(Gestao.Client._Imports).Assembly);

// Add additional endpoints required by the Identity /Account Razor components.
app.MapAdditionalIdentityEndpoints();

app.Run();
