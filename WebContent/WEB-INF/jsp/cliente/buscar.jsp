<%@ include file="/header.jsp"%>

<div id="message">${msg}</div>
<fieldset>
	<div class="tabbable tabs-left">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#a" data-toggle="tab">Busca Normal</a></li>
			<li><a href="#b" data-toggle="tab">BuscaBR</a></li>
		</ul>
		<div class="tab-content">
			<div class="tab-pane active" id="a">
				<input type="text" class="search-query input-large"	placeholder="digite um nome" id="nome" name="cliente.nome" />
				<a type="button" class="btn" id="procurar" ><i class="icon-thumbs-up"></i>Vai! </a>
					<br/>
				<div class="span1 ">
				
						<table class="table table-condensed">
								<thead>
									<tr>
										<th>nome</th>
									</tr>
								</thead>
								<tbody id="result" ></tbody>
							</table>
																	
				
				</div>
			</div>
			
			<div class="tab-pane" id="b">
				<p>Howdy, I'm in Section B.</p>
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
