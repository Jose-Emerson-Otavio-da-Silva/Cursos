using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace Gestao.Migrations
{
    /// <inheritdoc />
    public partial class databaseV40 : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<DateTimeOffset>(
                name: "BalanceDateNew",
                table: "Accounts",
                type: "datetimeoffset",
                nullable: false,
                defaultValue: new DateTimeOffset(DateTime.Now));

            migrationBuilder.DropColumn(
                name: "BalanceDate",
                table: "Accounts");

            migrationBuilder.RenameColumn(
                name: "BalanceDateNew",
                table: "Accounts",
                newName: "BalanceDate");

        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.RenameColumn(
                name: "BalanceDate",
                table: "Accounts",
                newName: "BalanceDateNew");

            migrationBuilder.AddColumn<decimal>(
                name: "BalanceDate",
                table: "Accounts",
                type: "decimal(18,2)",
                nullable: false,
                defaultValue: 0m);

            migrationBuilder.DropColumn(
                name: "BalanceDateNew",
                table: "Accounts");
        }
    }
}
