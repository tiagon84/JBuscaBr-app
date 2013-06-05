<%@ include file="/header.jsp"%>

<div id="message">${msg}</div>
<fieldset>
	<div class="tabbable tabs-left">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#lA" data-toggle="tab">Busca Normal</a></li>
			<li><a href="#lB" data-toggle="tab">BuscaBR</a></li>
		</ul>
		<div class="tab-content">
			<div class="tab-pane active" id="lA">
				<input type="text" class="search-query input-large"	placeholder="digite um nome" id="nome" name="cliente.nome" />
				<a type="button" class="btn" id="procurar" ><i class="icon-thumbs-up"></i>Vai! </a>
			</div>
			
			<div class="tab-pane" id="lB">
				<p>Howdy, I'm in Section B.</p>
			</div>
		</div>
	</div>

	<form class="form-search"	action="<c:url value="/clientes/procura-normal"/>" method="post">
	</form>

</fieldset>

<%@ include file="/footer.jsp"%>
