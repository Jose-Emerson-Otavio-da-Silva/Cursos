using System.Net.Mail;
using Gestao.Domain;
using Microsoft.AspNetCore.Identity;
using Microsoft.Extensions.Options;

namespace Gestao.Libraries.Mail
{
    /// <summary>
    /// Classe EmailSender responsável por enviar e-mails
    /// </summary>
    /// <param name="logger"></param>
    /// <param name="configuration"></param>
    /// <param name="smtp"></param>
    public class EmailSender(ILogger<EmailSender> logger, IConfiguration configuration, SmtpClient smtp) : IEmailSender<ApplicationUser>
    {
        // Instância do logger para registrar eventos de envio de e-mails
        private readonly ILogger logger = logger;

        // Cliente SMTP para envio de e-mails
        private readonly SmtpClient smtp = smtp;

        // Instância de configuração para acessar as configurações da aplicação
        private readonly IConfiguration configuration = configuration;

        // Envia um e-mail com o link de confirmação para o usuário
        public Task SendConfirmationLinkAsync(ApplicationUser user, string email,
            string confirmationLink) => SendEmailAsync(email, "Confirme seu e-mail",
            "<html lang=\"en\"><head></head><body>Por favor confirme seu cadastro clicando no link: " +
            $"<a href='{confirmationLink}'>Confirmar</a>.</body></html>");

        // Envia um e-mail com o link para redefinição de senha para o usuário
        public Task SendPasswordResetLinkAsync(ApplicationUser user, string email,
            string resetLink) => SendEmailAsync(email, "Resetar senha",
            "<html lang=\"en\"><head></head><body>Resete sua senha clicando no link: " +
            $"<a href='{resetLink}'>Resetar senha</a>.</body></html>");

        // Envia um e-mail com o código para redefinição de senha para o usuário
        public Task SendPasswordResetCodeAsync(ApplicationUser user, string email,
            string resetCode) => SendEmailAsync(email, "Resetar senha",
            "<html lang=\"en\"><head></head><body>Resete sua senha " +
            $"usando o seguinte código:<br>{resetCode}</body></html>");

        // Envia um e-mail de forma assíncrona
        public async Task SendEmailAsync(string toEmail, string subject, string message)
        {
            await Execute(subject, message, toEmail);
        }

        // Executa o processo de envio do e-mail
        public async Task Execute(string subject, string message,
            string toEmail)
        {
            // Cria uma nova mensagem de e-mail
            var mailMessage = new MailMessage();
            mailMessage.From = new MailAddress(configuration.GetValue<string>("EmailSender:User")!); // Endereço de e-mail do remetente
            mailMessage.To.Add(new MailAddress(toEmail)); // Endereço de e-mail do destinatário
            mailMessage.Subject = subject; // Assunto do e-mail
            mailMessage.Body = message; // Corpo do e-mail
            mailMessage.IsBodyHtml = true; // Indica que o corpo do e-mail é HTML

            // Envia o e-mail usando o cliente SMTP
            await smtp.SendMailAsync(mailMessage);

            // Registra o evento de envio do e-mail
            logger.LogInformation("E-mail para {EmailAddress} enviado!", toEmail);
        }
    }
}