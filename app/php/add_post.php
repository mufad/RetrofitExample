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
      echo "Connection failed";
   }

  if ($_SERVER['REQUEST_METHOD'] === 'POST'){
    $data=file_get_contents('php://input');
    $json_data = json_decode($data , true);
    
    $name=$json_data['name'];
    $post=$json_data['post'];
    
    $sql= "INSERT INTO user_info(name,note) VALUES('".$name."','".$post."');";
    
     if (mysqli_query($conn, $sql)) {
        
        $response = array('status' => true, 'message' => 'Post added Successfully');
        
    } else {
        $response = array('status' => false, 'message' => 'Cannot add post');
        }
    echo json_encode($response);
    $conn->close();
  }
?>
