global using AutoMapper;
using Microsoft.EntityFrameworkCore;
using ServicioMedico.Data;
using ServicioMedico.Entities;
using ServicioMedico.Mapper;
using ServicioMedico.Repositories;
using ServicioMedico.ServiceImpl;
using System.Text.Json.Serialization;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddDbContext<DataContext>(options =>
{
    options.UseLazyLoadingProxies().UseSqlServer(builder.Configuration.GetConnectionString("DefaultConnection"));
});

builder.Services.AddScoped<CitaRepository>();
builder.Services.AddScoped<CitaService>();
builder.Services.AddScoped<DiagnosticoRepository>();
builder.Services.AddScoped<DiagnosticoService>();
builder.Services.AddScoped<PacienteRepository>();
builder.Services.AddScoped<PacienteService>();
builder.Services.AddScoped<MedicoRepository>();
builder.Services.AddScoped<MedicoService>();
builder.Services.AddScoped<UsuarioRepository>();
builder.Services.AddScoped<UsuarioService>();
/*builder.Services.AddScoped<ICitaService,CitaServic>();*/
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();
builder.Services.AddControllers();
builder.Services.AddCors( options =>
{
    options.AddPolicy(name: "prueba",
    builder =>
    {
        builder.WithOrigins("http://localhost:4200")
        .AllowAnyMethod()
        .AllowAnyHeader();
    });


});

//mapper

var mapperConfig = new MapperConfiguration(m =>
    {
        m.AddProfile(new CitaMapper());
        m.AddProfile(new DiagnosticoMapper());
        m.AddProfile(new MedicoMapper());
        m.AddProfile(new PacienteMapper());
        m.AddProfile(new UsuarioMapper());
    });
    
IMapper mapper = mapperConfig.CreateMapper();
builder.Services.AddSingleton(mapper);
builder.Services.AddMvc();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
