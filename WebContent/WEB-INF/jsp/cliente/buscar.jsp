<%@ include file="/header.jsp"%>

<div id="message">${msg}</div>
<fieldset>
	<div class="tabbable tabs-left">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#a" data-toggle="tab">Busca Regular</a></li>
			<li><a href="#b" data-toggle="tab">JBuscaBR</a></li>
		</ul>
		<div class="tab-content">
			<div class="tab-pane active" id="a">
			<label>Busca Regular</label>
				<input type="text" class=" search-query input-large"	placeholder="digite um nome" id="nome" name="cliente.nome" />
				<a type="button" class="btn" id="procurar-normal" ><i class="icon-thumbs-up"></i>Vai! </a>
				<br/>
				<div class="span3 table-result form-signin">
				
					<table class="table table-hover">
						<thead>
							<tr>
								<th></th>
							</tr>
						</thead>
						<tbody id="result" ></tbody>
					</table>
					
				</div>
			</div>
			
			<div class="tab-pane" id="b">
				<label>JBuscaBR</label>
				<input type="text" class="search-query input-large"	placeholder="digite um nome" id="nome-buscabr" name="cliente.nome" />
				<a type="button" class="btn" id="procurar-buscabr" ><i class="icon-thumbs-up"></i>Vai! </a>
					<br/>
				<div class="span3 table-result form-signin">
				
					<table class="table table-hover">
						<thead>
							<tr>
							<th></th>
							</tr>
						</thead>
						<tbody id="result-buscabr" ></tbody>
					</table>
				</div>
			</div>
		</div>
	</div>


</fieldset>

<script type="text/html" id="template">
<tr >
	<td data-content="nome" ></td>
</tr>
</script>

<%@ include file="/footer.jsp"%>
