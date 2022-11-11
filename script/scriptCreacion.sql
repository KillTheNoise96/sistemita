CREATE TABLE [dbo].[CLIENTES_RONNY](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[PRIMER_NOMBRE] [varchar](30) NOT NULL,
	[SEGUNDO_NOMBRE] [varchar](30) NULL,
	[PRIMER_APELLIDO] [varchar](30) NOT NULL,
	[SEGUNDO_APELLIDO] [varchar](30) NULL,
	[SEXO] [varchar](1) NULL,
	[CELULAR] INT
 CONSTRAINT [PK_CLIENTES_RONNY] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO;

Insert into dbo.CLIENTES_RONNY values('mayron','josue','barboza','mendoza','M',1234678);
Insert into dbo.CLIENTES_RONNY values('douglas','eli','bello','ruiz','M',1234678);
Insert into dbo.CLIENTES_RONNY values('Juan2','Carlos2','Morales2','Aleman2','M',1234678);
Insert into dbo.CLIENTES_RONNY values('Julio','josue','Lopez','Lopez','M',1234678);
Insert into dbo.CLIENTES_RONNY values('JUAN','JUAN2','JUAN3','JUAN4','M',1234678);

