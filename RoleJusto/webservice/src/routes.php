<?php
// Routes

$app->get('/veiculo/list', function ($request, $response) {

	$db = $this->db;
	foreach($db->query('SELECT * FROM veiculo') as $row){
		$return[] = $row;
	};

	return $response->withJson($return);
});




$app->post('/veiculo/new', function ($request, $response) {

	$db = $this->db;
	$veiculo = $request->getParsedBody();
	$sth = $db->prepare("INSERT INTO veiculo(nome_vei, modelo_vei, ano_vei, combustivel_vei, consumo_vei) VALUES (:nome_vei, :modelo_vei, :ano_vei, :combustivel_vei, :consumo_vei)");

	$insertVeiculo['nome_vei']    		= $veiculo['nome_vei'];
  	$insertVeiculo['modelo_vei']   		= $veiculo['modelo_vei'];
  	$insertVeiculo['ano_vei']    			= $veiculo['ano_vei'];
  	$insertVeiculo['combustivel_vei']   = $veiculo['combustivel_vei'];
  	$insertVeiculo['consumo_vei']    	= $veiculo['consumo_vei'];

	$sth->execute($insertVeiculo);
	return $response->withJson($insertVeiculo); 

});




$app->get('/role/list', function ($request, $response) {

	$db = $this->db;
	foreach($db->query('SELECT * FROM role') as $row){
		$return[] = $row;
	};

	return $response->withJson($return);
});





$app->post('/role/new', function ($request, $response) {

	$db = $this->db;
	$role = $request->getParsedBody();
	$sth = $db->prepare("INSERT INTO role(distancia, 
										  valor_total_pedagio, 
										  valor_litro_combustivel, 
										  valor_total_combustivel,
										  consumo,
										  quant_pessoas,
										  valor_total_role,
										  valor_por_pessoa) 
						  VALUES (:distancia, 
								  :valor_total_pedagio, 
								  :valor_litro_combustivel, 
								  :valor_total_combustivel,
								  :consumo,
								  :quant_pessoas,
								  :valor_total_role,
								  :valor_por_pessoa)"
						);

	$insertRole['distancia']    			= $role['distancia'];
  	$insertRole['valor_total_pedagio']   	= $role['valor_total_pedagio'];
  	$insertRole['valor_litro_combustivel']  = $role['valor_litro_combustivel'];
  	$insertRole['valor_total_combustivel']  = $role['valor_total_combustivel'];
  	$insertRole['consumo']    				= $role['consumo'];
  	$insertRole['quant_pessoas']    		= $role['quant_pessoas'];
  	$insertRole['valor_total_role']   		= $role['valor_total_role'];
  	$insertRole['valor_por_pessoa']  		= $role['valor_por_pessoa'];

	$sth->execute($insertRole);
	return $response->withJson($insertRole); 

});
