using Gestao.Data;
using Microsoft.AspNetCore.Identity;
using Microsoft.Extensions.Options;

namespace Gestao.Libraries.Mail
{
    public class EmailSender(ILogger<EmailSender> logger) : IEmailSender<ApplicationUser>
    {
        private readonly ILogger logger = logger;

        public Task SendConfirmationLinkAsync(ApplicationUser user, string email,
            string confirmationLink) => SendEmailAsync(email, "Confirme seu e-mail",
            "<html lang=\"en\"><head></head><body>Por favor confirme seu cadastro clicando no link: " +
            $"<a href='{confirmationLink}'>Confirmar</a>.</body></html>");

        public Task SendPasswordResetLinkAsync(ApplicationUser user, string email,
            string resetLink) => SendEmailAsync(email, "Resetar senha",
            "<html lang=\"en\"><head></head><body>Resete sua senha clicando no link: " +
            $"<a href='{resetLink}'>Resetar senha</a>.</body></html>");

        public Task SendPasswordResetCodeAsync(ApplicationUser user, string email,
            string resetCode) => SendEmailAsync(email, "Resetar senha",
            "<html lang=\"en\"><head></head><body>Reset sua senha " +
            $"usando o seguinte código:<br>{resetCode}</body></html>");

        public async Task SendEmailAsync(string toEmail, string subject, string message)
        {
            await Execute(subject, message, toEmail);
        }

        public async Task Execute(string subject, string message,
            string toEmail)
        {
            /*
            * Substituir o Mandrill pelo SMTP - Gmail
            *
            var api = new MandrillApi(apiKey);
            var mandrillMessage = new MandrillMessage("sarah@contoso.com", toEmail, 
                subject, message);
            await api.Messages.SendAsync(mandrillMessage);*/

            logger.LogInformation("Email to {EmailAddress} sent!", toEmail);
        }
    }
}