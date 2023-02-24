<html>
<head>
<title>
Search your Medicine
</title>
<script>
    function Search(){

        let name = document.getElementById("name").value;
        let district = document.getElementById("district").value;

        (async () => {
            const response = await fetch('api/stock/find?medicine=' + encodeURIComponent(name) + "&district=" + encodeURIComponent(district), {
                method: 'GET',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
/*                body: JSON.stringify({medicine: name, district: district})*/
            });
            const content = await response.json();

            let tbody = "";

            for (let x of content.keys()) {
                let stock = content[x];
                tbody += `        <tr bgcolor="lightgrey" align="center">
            <td>`+ stock['medicine']['englishName'] +`</td>
            <td>`+ stock['pharmacy']['name'] +`</td>
            <td>`+ stock['pharmacy']['district'] +`</td>
            <td>Rs.`+ stock['price']+`/=</td>
            <td>`+ stock['quantity']+`</td>
        </tr>`;
            }


            document.head.title = "Search results";
            document.body.innerHTML = `    <h1 align="center">Search Results</h1>
    <table bgcolor="black" width="1000">
        <tr bgcolor="grey">
            <th width="200">Medicine</th>
            <th width="200">Pharmacy</th>
            <th width="200">District</th>
            <th width="200">Medicine Price</th>
            <th width="200">Number of cards/Capsules</th>
        </tr>`+ tbody+
                `</table>`;

        })();
    }
</script>  
<link rel="stylesheet" type="text/css" href="../../resources/css/stylesheet.css">
</head>
<body>
<div id="nav">
Search your Medicine<br>
<input id="name" type="text" placeholder="Medicine Name"><br>
<input id="district" type="text" placeholder="District"><br>
<input type="button" onclick="Search()" value="Search">
</div>
</body>
</html>