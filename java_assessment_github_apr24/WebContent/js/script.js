function initAJAX() {
	var xmlHttpRequest;
	
	if (window.XMLHttpRequest) {
		xmlHttpRequest = new XMLHttpRequest();
	} else {
		xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlHttpRequest;
}

function displayUsers() {
	$.getJSON('https://api.github.com/users', function(data) {
		var html = '<h2>User List</h2>';
		$.each(data, function(index, value) {
			html += '<p onclick="displayUserFollowers('+ value.login +')">' + value.login + '</p>';
			
			// create followers list
			html += '<div id=' + value.login +'>';
			$.getJSON(value.followers_url, function(data) {
				$.each(data, function(index, value) {
					html += '<img src="' + data.avatar_url + '" width="20" height="20" />';
				});
			});
			html += '</div>';
			
			// hide followers list
			var x = document.getElementById(value.login);
			x.style.display = "none";
		});
		$("#contentBlock").html(html);
	});
}

function displayUserFollowers(div_id) {
	// show followers list
	var x = document.getElementById(div_id);
	x.style.display = "block";
}