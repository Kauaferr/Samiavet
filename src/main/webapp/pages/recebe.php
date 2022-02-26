<?php
    if(isset($_POST['acao'])){
        $arquivo = $_FILES['file'];
        $_arquivoNovo = explode('.' , $arquivo['name']);

        if($_arquivoNovo[sizeof($_arquivoNovo) - 1] != 'jpg'){
            die('Você não pode fazer upload desse tipo de arquivo');
        }else{
            echo('Upload realizado com sucesso');
            move_uploaded_file($arquivo['tmp_name'], 'target/' .$arquivo['name']);
        }
    }     
?>



<html>
<head>
   
</head>
<body>
        <form action="" method = "post" enctype="multipart/form-data">
            <input type="file" name="file" />
            <inputt type ="submit" name="acao" value="Enviar">

</body>
</html>