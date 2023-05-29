<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cadastro de Materiais</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="corUniceplac.css">

<link rel="shortcut icon" href="">

</head>
<body>

	<!-- Container com Conteúdo -->
	<div class="container">

		<!-- Contagem de Itens no Estoque -->
		<div class="itensEstoque">
			<h2>
				Materiais Cadastrados: <br>
				<br> <span id="totalEstoque">0</span>
			</h2>
		</div>

		<!-- Título -->
		<h1 class="titulo">Editar Materiais</h1>

		<!-- Formulário: Nome, código e quantidade de material -->
		<form name="frmMaterial" action="update">

			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label"
					style="font-size: 25px;" >Id Material</label> <input
					type="text" class="form-control nome_mat" name="idmaterial" readonly value="<%out.print(request.getAttribute("idmaterial"));%>">
				<!-- Nome do material -->
			</div>
			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label"
					style="font-size: 25px;">Nome do Material</label> <input
					type="text" class="form-control nome_mat" name="nome" value="<%out.print(request.getAttribute("nome"));%>">
				<!-- Nome do material -->
			</div>



			<div class="mb-3">
				<label for="formGroupExampleInput2" class="form-label"
					style="font-size: 25px;">Código do Material</label> <input
					type="text" class="form-control codigo_mat" name="codMaterial" value="<%out.print(request.getAttribute("codMaterial"));%>">
				<!-- Código do material -->
			</div>


			<!-- Quantidade do material -->
			<div class="form-group">
				<label for="exampleFormControlSelect1" style="font-size: 25px;">Quantidade
					de Materiais</label> <input type="number" class="form-control codigo_mat"
					name="quantidade" value="<%out.print(request.getAttribute("quantidade"));%>">

			</div>



			<!-- Botões -->
			<input type="button" value="Salvar" class="btn btn-Orange btn-lg"
				style="color: white;" onclick="validar()">

			<!-- onclick="validarMaterial('txtNomeMaterial', 'txtCodMaterial', 'qtidadeMaterial') " -->

			<!-- <input type="button" value="Ver Estoque" class="btn btn-Orange btn-lg" style="color: white;"
onclick="window.open('verEstoque.html', '')"> -->

			<input type="reset" value="Limpar Informações"
				class="btn btn-Orange btn-lg" style="color: white;">

			<!-- <input type="reset" value="Limpar Estoque"class="btn btn-Orange btn-lg" style="color: white;" onclick="limparTotalEstoque()"> -->

		</form>


	</div>


	<script src="scripts/validador.js"></script>
	<script src="script.js"></script>



</body>
</html>