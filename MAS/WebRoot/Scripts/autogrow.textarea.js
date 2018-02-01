/*
Auto-growing textareas; technique ripped from Facebook
(Textarea need set style "overflow:hidden" under IE)
*/
(function($) {
function times(string, number) {
  for (var i = 0, r = ''; i < number; i ++) r += string;
  return r;
}
 
$.fn.autogrow = function(options) {
  this.filter('textarea').each(function() {
    this.timeoutId = null;
    var $this = $(this), minHeight = $this.height();
    var shadow = $('<div></div>').css({
      position:   'absolute',
      wordWrap:   'break-word',
      top:        0,
      left:       -9999,
      display:    'none',
      width:      $this.width(),
      fontSize:   $this.css('fontSize'),
      fontFamily: $this.css('fontFamily'),
      lineHeight: $this.css('lineHeight')
    }).appendTo(document.body);
 
    var update = function() {
      var val = this.value.replace(/</g, '&lt;')
        .replace(/>/g, '&gt;')
        .replace(/&/g, '&amp;')
        .replace(/\n$/, '<br/>&nbsp;')
        .replace(/\n/g, '<br/>')
        .replace(/ {2,}/g, function(space) { return times('&nbsp;', space.length -1) + ' ' });
      shadow.html(val);
      $(this).css('height', Math.max(shadow.height(), minHeight));
    }
     
    var updateTimeout = function() {
      clearTimeout(this.timeoutId);
      var that = this;
      this.timeoutId = setTimeout(function(){ update.apply(that); }, 100);
    };
 
    $(this).change(update).keyup(updateTimeout).keydown(updateTimeout);
    update.apply(this);
  });
  return this;
}
})(jQuery);
