var root = location.origin +'/save_once/'; 

function getCategory(code_id){
		
		var selectedVal = $('#upperCateList option:selected').text();
		
		$('#upperInput').val(selectedVal);
		
		$('option').remove('#downCate');
		$.ajax({
			url : root+'admin/getCategory/'+code_id,
			type : 'get',
			dataType : 'json',
			success : function(data){
				$.each(data,function(i){
					$('#downCateList').append('<option onclick="getDownCategory()" id="downCate" value="'+data[i].code_grid+'">'+data[i].code_name+'</option>');
				})
			}
		})
	}
	
	function getDownCategory(){
		
		var selectedVal = $('#downCateList option:selected').text();
		
		$('#downInput').val(selectedVal);
		
	}
	
	function addUpperCategory(){
		
		var val = $('#upperInput').val();
		
		if(val == ''){
			alert('카테고리 이름을 입력해주세요.')
			return;
		}
			$.ajax({
				url : root+'admin/addUpperCategory',
				type : 'post',
				data: {code_name : val},
				success: function(response) {
					if(response == 'true'){
						location.reload();
						alert(val+' 카테고리가 추가되었습니다.');
					}else{
						console.log('fail');
					}
				},
				error: function (xhr, status, error) {
			        console.error('Error:', status, error);
			    }
			});
			
		
		
	}
	
	function modifyUpperCategory(){
		
		var val1 = $('#upperCateList option:selected').val();
		var val2 = $('#upperInput').val();
		
		if(val2 == ''){
			alert('카테고리 이름을 입력해주세요.')
			return;
		}else if(val1 == undefined){
			alert('대분류 카테고리를 선택해주세요.');
			return;
		}	
		
			const modifyCategoryBean = {
					code_name : val2,
					code_id : val1
			}
			
			console.log(modifyCategoryBean)
			
			$.ajax({
				url : root+'admin/modifyUpperCategory',
				type : 'post',
				data: modifyCategoryBean,
				success: function(response) {
					$('#upperCateList option[value="' + val1 + '"]').text(val2);
				},
				error: function (xhr, status, error) {
			        console.error('Error:', status, error);
			    }
			});
	}
	
	function deleteUpperCategory(){
		
		var val = $('#upperCateList option:selected').val();
		const data = { code_id : val }
		console.log(data)
		$.ajax({
			url : root+'admin/deleteUpperCategory',
			type : 'post',
			data : data,
			success: function(response) {
				$('option').remove('#downCate');
				$('#upperCateList option:selected').remove();
			},
			error: function (xhr, status, error) {
		        console.error('Error:', status, error);
		    }
		});
		
		
	}
	
	function addDownCategory(){
		
		var val1 = $('#downInput').val();
		var val2 = $('#upperCateList option:selected').val();
		
		if(val1==''){
			alert('카테고리 이름을 입력해주세요.')
			return;
		}else if(val2==undefined){
			alert('대분류 카테고리를 선택해주세요.');
			return;
		}
		
		const data = { code_name : val1, code_id : val2 }
		console.log(data);
		$.ajax({
			url : root+'admin/addDownCategory',
			type : 'post',
			data: data,
			success: function(response) {
				if(response == 'true'){
					location.reload();
					alert(val1+' 카테고리가 추가되었습니다.');
				}else{
					console.log('fail');
				}
			},
			error: function (xhr, status, error) {
		        console.error('Error:', status, error);
		    }
		});
	}
	
	function modifyDownCategory(){
		
		var code_grid = $('#downCateList option:selected').val();
		var code_name = $('#downInput').val();
		if(code_name==''){
			alert('카테고리 이름을 입력해주세요.')
			return;
		}else if(code_grid==undefined){
			alert('카테고리를 선택해주세요.');
			return;
		}
		const data = { code_grid : code_grid , code_name : code_name }

		console.log(data);
		
		$.ajax({
			url : root+'admin/modifyDownCategory',
			type : 'post',
			data: data,
			success: function(response) {
				$('#downCateList option[value="' + code_grid + '"]').text(code_name);
			},
			error: function (xhr, status, error) {
		        console.error('Error:', status, error);
		    }
		});
		
	}
	
	function deleteDownCategory(){
		var code_grid = $('#downCateList option:selected').val();
		if(code_grid==undefined){
			alert('카테고리를 선택해주세요.');
			return;
		}
		const data = { code_grid : code_grid }
		console.log(data);
		$.ajax({
			url : root+'admin/deleteDownCategory',
			type : 'post',
			data : data,
			success: function(response) {
				$('#downCateList option[value="' + code_grid + '"]').remove();
			},
			error: function (xhr, status, error) {
		        console.error('Error:', status, error);
		    }
		});
		
	}