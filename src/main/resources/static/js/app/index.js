// index.js
/*
    저장(save), 수정(update), 삭제(delete), 추천(recommend) 기능을
    ajax를 통해 수행하고,
    게시판 화면에 alert을 표출해주는 기능 제공
*/


var main = {
    init : function(){
        var _this = this;

        $('#btn-write').on('click', function(){
            _this.save();
        });

        $('#btn-update').on('click', function(){
            _this.update();
        });

        $('#btn-delete').on('click', function(){
            _this.delete();
        });

        $('#btn-rec').on('click', function(){
            _this.rec();
        });
    },

    save : function(){
        var data = {
            title: $('#title').val(),
            content : $('#content').val(),
            author : $('#author').val()
        };

        // 여기서 required 확인하는 코드 필요          required 는 submit 일때 작동하는데 우리는 현재 클릭시 js로 처리중

        $.ajax({
                type: 'POST',
                dataType: 'json',
                url: '/api/v1/posts',    // localhost:8080/api/v1/posts
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
        }).done(function(returnData){
            alert('글이 등록되었습니다.');
            $("#debug").html(returnData);
            location.href='/';
        }).fail(function(error){
            // alert(error);
            $("#dubug").html(error);
            alert(JSON.stringify(error));
        });
    },

    update : function(){
        let id = $("#id").val();
        // alert('수정한 글 번호 = ' + id);

        var data = {
            title: $('#title').val(),
            content : $('#content').val(),
            author : $('#author').val()         // 수정할게 아니므로 안읽어와도 상관없음
        };

        $.ajax({
            type: 'PUT',
            dataType: 'json',
            url: '/api/v1/posts/' + id,               // localhost:8080/api/v1/posts/3
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(returnData){
            alert('변경되었습니다.');
            location.href='/';
        }).fail(function(error){
            alert(error);
        });
    },

    delete : function(){
        let id = $("#id").val();
        // alert('삭제할 글 번호 : ' + id);

        if(confirm('정말 삭제하시겠습니까?'))
        {
            $.ajax({
                type: 'DELETE',
                url: '/api/v1/posts/' + id,
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
            })
            .done(function(){
                alert('삭제되었습니다.');
                location.href='/';
            })
            .fail(function(error){
                alert(error);
            });
        }else
        {
            // 취소..
        }
    },

    rec : function(){
        let id = $("#id").val();
        // alert('추천 글 번호 = ' + id);

        $.ajax({
            type: 'POST',
            url: '/api/v1/rec/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        })
        .done(function(data){
            alert('추천되었습니다. :');

            let idRec = $("#idRec");
            let newRec = parseInt(idRec.html()) +1;
            idRec.html(newRec);
        })
        .fail(function(error){
            alert(JSON.stringify(error));
        });
    }
}

main.init();