<style type="text/css">
#menubv {
width: 12em;
padding: 0;
margin: 0;
font: 12px Verdana, sans-serif;
}
#menubv ul {
list-style: none;
margin: 0;
padding: 0;
}
#menubv li {
    border-bottom: 1px solid #e43d24;
margin: 0;
}
#menubv li a {
display: block;
padding: 5px 5px 5px 0.5em;
border-left: 10px solid #b7321e;
border-right: 10px solid #d74e39;
background-color: #c04633;
color: #fff;
text-decoration: none;
}
#menubv li a:hover {
    border-left: 10px solid #f23e3e;
    border-right: 10px solid #fa7f7f;
background-color: #fa5f5f;
color: lightgoldenrodyellow;
}
/* Fix IE. Hide from IE Mac \*/
* html ul#menubv  li { float: left; height: 1%; }
* html ul#menubv  li a { height: 1%; }
/* End */
</style>

<ul id="menubv">
<li>
<a href="adicionar_pessoa.jsp" target="alvo">Adicionar Pessoa</a>
</li>
<li>
<a href="ListarPessoas" target="alvo">Listar Pessoas</a>
</li>
<li>
<a href="adicionar_processo.jsp" target="alvo">Adicionar Processo</a>
</li>
<li>
<a href="ListarProcessos" target="alvo">Listar Processos</a>
</li>
</ul>