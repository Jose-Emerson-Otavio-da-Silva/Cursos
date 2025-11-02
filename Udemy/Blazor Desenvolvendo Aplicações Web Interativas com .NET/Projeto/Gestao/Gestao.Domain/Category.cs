namespace Gestao.Domain
{
    public class Category : Interfaces.SoftDelete
    {
        public int Id { get; set; }
        public string Name { get; set; } = null!;
        public int? CompanyId { get; set; }
        public Company? Company { get; set; }
        public DateTimeOffset CreatedAt { get; set; }
        public DateTimeOffset? DeletedAt { get; set; }
    }
}