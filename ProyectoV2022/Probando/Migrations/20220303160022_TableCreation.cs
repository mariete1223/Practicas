using System;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace ServicioMedico.Migrations
{
    public partial class TableCreation : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Diagnostico",
                columns: table => new
                {
                    Id = table.Column<long>(type: "bigint", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    valoracionEspedialista = table.Column<string>(type: "nvarchar(50)", maxLength: 50, nullable: false),
                    enfermedad = table.Column<string>(type: "nvarchar(30)", maxLength: 30, nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Diagnostico", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "Usuario",
                columns: table => new
                {
                    Id = table.Column<long>(type: "bigint", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    nombre = table.Column<string>(type: "nvarchar(15)", maxLength: 15, nullable: false),
                    apellidos = table.Column<string>(type: "nvarchar(25)", maxLength: 25, nullable: false),
                    usuario = table.Column<string>(type: "nvarchar(18)", maxLength: 18, nullable: false),
                    clave = table.Column<string>(type: "nvarchar(20)", maxLength: 20, nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Usuario", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "Medico",
                columns: table => new
                {
                    Id = table.Column<long>(type: "bigint", nullable: false),
                    numColegio = table.Column<string>(type: "nvarchar(15)", maxLength: 15, nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Medico", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Medico_Usuario_Id",
                        column: x => x.Id,
                        principalTable: "Usuario",
                        principalColumn: "Id");
                });

            migrationBuilder.CreateTable(
                name: "Paciente",
                columns: table => new
                {
                    Id = table.Column<long>(type: "bigint", nullable: false),
                    NSS = table.Column<string>(type: "nvarchar(11)", maxLength: 11, nullable: false),
                    numTarjeta = table.Column<string>(type: "nvarchar(16)", maxLength: 16, nullable: false),
                    telefono = table.Column<string>(type: "nvarchar(15)", maxLength: 15, nullable: false),
                    direccion = table.Column<string>(type: "nvarchar(30)", maxLength: 30, nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Paciente", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Paciente_Usuario_Id",
                        column: x => x.Id,
                        principalTable: "Usuario",
                        principalColumn: "Id");
                });

            migrationBuilder.CreateTable(
                name: "Cita",
                columns: table => new
                {
                    Id = table.Column<long>(type: "bigint", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    fechaHora1 = table.Column<DateTime>(type: "datetime2", nullable: false),
                    motivoCita = table.Column<string>(type: "nvarchar(50)", maxLength: 50, nullable: false),
                    attribute11 = table.Column<int>(type: "int", nullable: false),
                    diagnosticoFKId = table.Column<long>(type: "bigint", nullable: false),
                    medicoFKId = table.Column<long>(type: "bigint", nullable: false),
                    pacienteFKId = table.Column<long>(type: "bigint", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Cita", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Cita_Diagnostico_diagnosticoFKId",
                        column: x => x.diagnosticoFKId,
                        principalTable: "Diagnostico",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Cita_Medico_medicoFKId",
                        column: x => x.medicoFKId,
                        principalTable: "Medico",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Cita_Paciente_pacienteFKId",
                        column: x => x.pacienteFKId,
                        principalTable: "Paciente",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

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
                name: "IX_Cita_diagnosticoFKId",
                table: "Cita",
                column: "diagnosticoFKId",
                unique: true);

            migrationBuilder.CreateIndex(
                name: "IX_Cita_medicoFKId",
                table: "Cita",
                column: "medicoFKId");

            migrationBuilder.CreateIndex(
                name: "IX_Cita_pacienteFKId",
                table: "Cita",
                column: "pacienteFKId");

            migrationBuilder.CreateIndex(
                name: "IX_PacienteMedico_medicoId",
                table: "PacienteMedico",
                column: "medicoId");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Cita");

            migrationBuilder.DropTable(
                name: "PacienteMedico");

            migrationBuilder.DropTable(
                name: "Diagnostico");

            migrationBuilder.DropTable(
                name: "Medico");

            migrationBuilder.DropTable(
                name: "Paciente");

            migrationBuilder.DropTable(
                name: "Usuario");
        }
    }
}
