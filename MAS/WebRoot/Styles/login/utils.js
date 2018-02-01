var approve_status = {
  1: '学院编辑中',
  2: '学校编辑中',
  21: '学校审核中',
  22: '学校审核通过',
  23: '学校审核驳回',
  31: '教委审核中',
  32: '教委审核通过',
  33: '教委审核驳回',
  41: '教育部审核中',
  42: '教育部审核通过',
  43: '教育部审核驳回',
  97: '待审核',
  98: '审核通过',
  99: '审核不通过'
};
//var appeal_status = {1: '未接受', 2: '已接受', 3: '已申诉'};
var appeal_status = {1: '未接受', 2: '已接受', 3: '已做补充说明'};
var account_user_role = {'admin': '平台管理员', 'edu_ministry': '中心用户', 'edu_bureau': '省级用户', 'school': '学校用户', 'academy': '专业用户', 'expert': '专家用户'};
var majors = {1: '临床医学（不含中医相关领域）', 2: '会计', 3: '公共管理', 4: '口腔医学（不含中医相关领域）', 5: '艺术（音乐领域）', 6: '法律', 7: '教育', 8: '工商管理'};
var execopt = {url: '', opt: {}, msg: '操作成功', reload: true};

function getQueryString(name) {
  var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
  var r = window.location.search.substr(1).match(reg);
  if (r != null) return decodeURI(r[2]);
  return null;
}

(function ($) {
  $.fn.drags = function (opt) {
    opt = $.extend({
      handle: "",
      cursor: "move"
    }, opt);
    var $selected = this;
    var $elements = (opt.handle === "") ? $selected : $selected.find(opt.handle);
    $elements.css('cursor', opt.cursor).on("mousedown", function (e) {
      if ($(e.target).is(':input')) return true;
      e.preventDefault();
      var pos_y = $selected.offset().top - e.pageY, pos_x = $selected.offset().left - e.pageX;
      $(topDocument()).on("mousemove", function (e) {
        $selected.offset({top: e.pageY + pos_y, left: e.pageX + pos_x});
      }).on("mouseup", function () {
        $(this).off("mousemove");
      });
    });
    return this;
  };
})(jQuery);

Date.prototype.format = function (fmt) {
  var o = {
    'M+': this.getMonth() + 1,
    'd+': this.getDate(),
    'h+': this.getHours(),
    'm+': this.getMinutes(),
    's+': this.getSeconds(),
    'q+': Math.floor((this.getMonth() + 3) / 3),
    'S': this.getMilliseconds()
  };
  if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
  for (var k in o) if (new RegExp('(' + k + ')').test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (('00' + o[k]).substr(('' + o[k]).length)));
  return fmt;
};
function topDocument() {
  if (self == top) return document;
  return top.document;
}
function topBody() {
  return topDocument().body;
}
function loadjs(file) {
  var $top = $(topBody());
  if ($top.find('#loadjs').length) $top.find('#loadjs').attr({'src': file});
  else $('<scri' + 'pt>' + '</scr' + 'ipt>').attr({src: file, type: 'text/javascript', id: 'loadjs'}).appendTo($top);
}
function doexec(o) {
  o = $.extend({}, execopt, o);
  $.post(o.url, o.opt, function (data) {
    if (data.success) {
      if (o.reload) reload();
      alert(o.msg);
    } else alert(data.msg);
  });
}
function reload() {
  location.reload();
}