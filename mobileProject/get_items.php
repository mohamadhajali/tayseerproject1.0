<?php
	
		$server_name = "localhost";
		$username = "root";
		$password = "";
		$dbname = "hotel";
		
		$conn = new mysqli($server_name, $username, $password, $dbname);
		if ($conn->connect_error) {
			die("Connection failed: " . $conn->connect_error);
		} 
		$sql = "select * from room" ;
		
		$result = $conn->query($sql);
		$resultarray = array();
		while($row =mysqli_fetch_assoc($result))
		{
			$resultarray[] = $row;
		}
		echo json_encode($resultarray);
		
		$conn->close();
		
?>