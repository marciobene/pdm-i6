<?php
// Routes

$app->get('/departamento/list', function ($request, $response) {

	$db = $this->db;
	foreach($db->query('SELECT * FROM dep') as $row){
		$return[] = $row;
	};

	return $response->withJson($return);
});

$app->get('/funcionario/list', function ($request, $response) {

	$db = $this->db;
	foreach($db->query('SELECT * FROM emp') as $row){
		$return[] = $row;
	};

	return $response->withJson($return);
});

/*
$app->get('/funcionario/list', function ($request, $response) {

	$db = $this->db;
	foreach($db->query('SELECT * FROM v_emp') as $row){
		$result['n_emp']    = $row['f_n_emp'];
		$result['nome_emp'] = $row['f_nome_emp'];
		$result['cargo']    = $row['f_cargo'];
		$result['data_adm'] = $row['f_data_adm'];
		$result['sal']      = $row['f_sal'];
		$result['com']      = $row['f_com'];

		$result['departamento'] = [
			'n_dep'    => $row['d_n_dep'],
			'nome_dep' => $row['d_nome_dep'],
			'local_dep' => $row['d_local_dep'],
		];

		//if($row['c_n_emp'] != null){
			$result['chefe'] = [
				'n_emp' => $row['c_n_emp'],
				'nome_emp' => $row['c_nome_emp'],
				'cargo' => $row['c_cargo'],
				'data_adm' => $row['c_data_adm'],
				'sal' => $row['c_sal'],
				'com'=> $row['c_com']
			];
		//}

		$return[] = $result;
	};

	return $response->withJson($return);
});*/


$app->post('/departamento/new', function ($request, $response) {

	$db = $this->db;
	
	$sth = $db->prepare("INSERT INTO dep(nome_dep, local_dep) VALUES (:nome_dep, :local_dep)");
	$departamento = $request->getParsedBody();
 	$insertDepartamento['nome_dep']    = $departamento['nome_dep'];
  	$insertDepartamento['local_dep']   = $departamento['local_dep'];
  
	$sth->execute($insertDepartamento);
 	return $response->withJson($insertDepartamento);

});

$app->post('/funcionario/new', function ($request, $response) {

	$db = $this->db;
	$funcionario = $request->getParsedBody();
	$sth = $db->prepare("INSERT INTO emp(nome_emp, cargo, data_adm, sal, com) VALUES (:nome_emp, :cargo, :data_adm, :sal, :com)");

	$insertFuncionario['nome_emp']    = $funcionario['nome_emp'];
  	$insertFuncionario['cargo']   = $funcionario['cargo'];
  	$insertFuncionario['data_adm']    = $funcionario['data_adm'];
  	$insertFuncionario['sal']   = $funcionario['sal'];
  	$insertFuncionario['com']    = $funcionario['com'];

	$sth->execute($insertFuncionario);
	return $response->withJson($insertFuncionario); 

});