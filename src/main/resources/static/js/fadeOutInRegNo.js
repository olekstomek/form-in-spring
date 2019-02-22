$('#isCompany').change(function(){
  if (this.checked) {
    $('#showOrHideRegNo').fadeIn('slow');
    $('#RegNo').val('');
  } else {
    $('#showOrHideRegNo').fadeOut('slow');
    $('#RegNo').val('');
  }
});