// $(".qna-comment").on("click", ".answerWrite input[type=submit]", addAnswer);
$(".answerWrite input[type=submit]").click(addAnswer);
$(".form-delete input[type=submit]").click(deleteAnswer);

function addAnswer(e) {
  e.preventDefault();

  var queryString = $("form[name=answer]").serialize();

  $.ajax({
    type : 'post',
    url : '/api/qna/addAnswer',
    data : queryString,
    dataType : 'json',
    error: onError,
    success : onSuccess,
  });
}
function deleteAnswer(e) {
	  e.preventDefault();

	  var queryString = $("form[name=answer]").serialize();

	  $.ajax({
	    type : 'post',
	    url : '/api/qna/addAnswer',
	    data : queryString,
	    dataType : 'json',
	    error: onError,
	    success : onSuccess,
	  });
	}

function onSuccess(json, status){
  var answer = json.answer;
  console.log(answer);
  var answerTemplate = $("#answerTemplate").html();
  var template = answerTemplate.format(answer.writer, new Date(answer.createdDate), answer.contents, answer.answerId, answer.answerId);
  $(".qna-comment-slipp-articles").prepend(template);
  $(".qna-comment-count strong").html("");
}

function onError(xhr, status) {
  alert("error");
}

String.prototype.format = function() {
  var args = arguments;
  return this.replace(/{(\d+)}/g, function(match, number) {
    return typeof args[number] != 'undefined'
        ? args[number]
        : match
        ;
  });
};