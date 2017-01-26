<?php 
    $servername = "mysql1002.mochahost.com";
    $username = "sakib777_dd";
    $password = "100%safe";
    $db_name="sakib777_test";


    // Create connection
    $conn = new mysqli($servername, $username, $password, $db_name);

    // Check connection

    if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
    }else{
   }

    if ($_SERVER['REQUEST_METHOD'] === 'POST'){
    $data=file_get_contents('php://input');
    $json_data = json_decode($data , true);

    $name=$json_data['name'];
    $email=$json_data['email'];
    $passwords=$json_data['password'];
 

   $sql="INSERT INTO user_info(name, password, email) VALUES('".$name."','".$passwords."','".$email."');";

    if (mysqli_query($conn, $sql)) {
        
        $response = array('status' => true, 'message' => 'Registration Successful');
        
    } else {
        echo "Error: " . $sql . "<br>" . mysqli_error($conn);
    }
    echo json_encode($response);
    $conn->close();
}
?>