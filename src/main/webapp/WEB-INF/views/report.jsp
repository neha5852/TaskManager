<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Users List</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<script>
    function createPDF() {
        var sTable = document.getElementById('tblData').innerHTML;

        var style = "<style>";
        style = style + "table {width: 100%;font: 17px Calibri;}";
        style = style + "table, th, td {border: solid 1px #DDD; border-collapse: collapse;";
        style = style + "padding: 2px 3px;text-align: center;}";
        style = style + "</style>";

        // CREATE A WINDOW OBJECT.
        var win = window.open('', '', 'height=700,width=700');

        win.document.write('<html><head>');
        win.document.write('<title>Users List</title>');   // <title> FOR PDF HEADER.
        win.document.write(style);          // ADD STYLE INSIDE THE HEAD TAG.
        win.document.write('</head>');
        win.document.write('<body>');
        win.document.write(sTable);         // THE TABLE CONTENTS INSIDE THE BODY TAG.
        win.document.write('</body></html>');

        win.document.close(); 	// CLOSE THE CURRENT WINDOW.

        win.print();    // PRINT THE CONTENTS.
    }
    
  
function exportTableToExcel(tableID,filename) {
    var downloadLink;
    var dataType = 'application/vnd.ms-excel';
    var tableSelect = document.getElementById(tableID);
    var tableHTML = tableSelect.outerHTML.replace(/ /g, '%20');
    
    // Specify file name
    filename = filename?filename+'.xls':'excel_data.xls';
    
    // Create download link element
    downloadLink = document.createElement("a");
    
    document.body.appendChild(downloadLink);
    
    if(navigator.msSaveOrOpenBlob){
        var blob = new Blob(['\ufeff', tableHTML], {
            type: dataType
        });
        navigator.msSaveOrOpenBlob( blob, filename);
    }else{
        // Create a link to the file
        downloadLink.href = 'data:' + dataType + ', ' + tableHTML;
    
        // Setting the file name
        downloadLink.download = filename;
        
        //triggering the function
        downloadLink.click();
    }
}


function downloadCSV(csv, filename) {
    var csvFile;
    var downloadLink;

    // CSV file
    csvFile = new Blob([csv], {type: "text/csv"});

    // Download link
    downloadLink = document.createElement("a");

    // File name
    downloadLink.download = filename;

    // Create a link to the file
    downloadLink.href = window.URL.createObjectURL(csvFile);

    // Hide download link
    downloadLink.style.display = "none";

    // Add the link to DOM
    document.body.appendChild(downloadLink);

    // Click download link
    downloadLink.click();
}
function exportTableToCSV(filename) {
    var csv = [];
    var rows = document.querySelectorAll("table,thead,tbody, tr");
    
    for (var i = 0; i < rows.length; i++) {
        var row = [], cols = rows[i].querySelectorAll("td, th");
        
        for (var j = 0; j < cols.length; j++) 
            row.push(cols[j].innerText);
        
        csv.push(row.join(","));        
    }

    // Download CSV file
    downloadCSV(csv.join("\n"), filename);
}
</script>

<body>
	<div class="generic-container">
		<%@include file="authheader.jsp" %>	
		 <button class="btn" onclick="history.back()"><i class="fa fa-home"></i></button>
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">Report </span></div>
		  			<table class="table table-hover" id="tblData">
	    		<thead>
		      		<tr>
				        <th>Project name</th>
				        <th>Schedule Variance</th>
				        <th>Effort Variance (%)</th>
				        <th>Delivered</th>
				        <th>Production </th>
				        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
				        	<th width="100"></th>
				        </sec:authorize>
				        <sec:authorize access="hasRole('ADMIN')">
				        	<th width="100"></th>
				        </sec:authorize>
				        
					</tr>
		    	</thead>
	    	 	<tbody>
				<c:forEach items="${projectReport}" var="project">
					<tr>
						<td>${project.projectName}</td>
						<td>${project.scheduleVariance}</td>
						<td>${project.effortVariance}</td>
						<td>${project.delivered}</td>
						<td>${project.production}</td>
					  
					</tr>
				</c:forEach>  
	    		</tbody> 
	    	</table>
			<p>
				<input type="button" value="Generate Report in PDF" id="btPrint"
					onclick="createPDF()" />
				<button onclick="exportTableToExcel('tblData', 'ProjectReport')">Generate
					Report in EXCEL</button>
				<button onclick="exportTableToCSV('ProjectReport.csv')">Generate
					Report in CSV</button>
			</p>
		</div>
				   </div>
				      
   	<%@include file="authheader.jsp" %>
   	
   	
</body>
</html>