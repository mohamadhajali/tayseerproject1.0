<?php 
if($_SERVER['REQUEST_METHOD'] == 'GET'){
        $server_name = "localhost";
		$username = "root";
		$password = "";
		$dbname = "hotel";

    $conn = new mysqli($server_name,$username,$password,$dbname);

    if($conn->connect_error){
        die("Connection failed: " . $conn->connect_error);
    }

    
    if(isset($_GET['userName']))
        $userName = $_GET['userName'];
    else 
        die("empty username");
        
    $sql = "select username from customer where username = '$userName'";
    $result = $conn->query($sql);

    if($result->num_rows>0)
        echo"Log in successfully";
    else
        echo"Invalid request";



    $conn->close();


}











?>