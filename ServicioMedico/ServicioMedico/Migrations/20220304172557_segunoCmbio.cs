using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace ServicioMedico.Migrations
{
    public partial class segunoCmbio : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "PacienteMedico");

            migrationBuilder.CreateTable(
                name: "MedicoPaciente",
                columns: table => new
                {
                    medicosId = table.Column<long>(type: "bigint", nullable: false),
                    pacientesId = table.Column<long>(type: "bigint", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_MedicoPaciente", x => new { x.medicosId, x.pacientesId });
                    table.ForeignKey(
                        name: "FK_MedicoPaciente_Medico_medicosId",
                        column: x => x.medicosId,
                        principalTable: "Medico",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_MedicoPaciente_Paciente_pacientesId",
                        column: x => x.pacientesId,
                        principalTable: "Paciente",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateIndex(
                name: "IX_MedicoPaciente_pacientesId",
                table: "MedicoPaciente",
                column: "pacientesId");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "MedicoPaciente");

            migrationBuilder.CreateTable(
                name: "PacienteMedico",
                columns: table => new
                {
                    pacienteId = table.Column<long>(type: "bigint", nullable: false),
                    medicoId = table.Column<long>(type: "bigint", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_PacienteMedico", x => new { x.pacienteId, x.medicoId });
                    table.ForeignKey(
                        name: "FK_PacienteMedico_Medico_medicoId",
                        column: x => x.medicoId,
                        principalTable: "Medico",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_PacienteMedico_Paciente_pacienteId",
                        column: x => x.pacienteId,
                        principalTable: "Paciente",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateIndex(
                name: "IX_PacienteMedico_medicoId",
                table: "PacienteMedico",
                column: "medicoId");
        }
    }
}
