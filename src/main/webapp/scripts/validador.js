/**
 * Validação de formulário
 */
 
 function validar() {
	let nome = frmMaterial.nome.value
	let codMaterial = frmMaterial.codMaterial.value
	let quantidade = frmMaterial.quantidade.value
	if (nome === "") {
		alert('Preencha o campo Nome')
		frmMaterial.nome.focus()
		return false
	} else if (codMaterial === '') {
		alert('Preencha o campo Código do Material')
		frmMaterial.codMaterial.focus()
		return false		
	} else if (quantidade === '') {
		alert('Preencha o campo Quantidade')
		frmMaterial.quantidade.focus()
		return false
	} else {
		document.forms["frmMaterial"].submit()
	}
}