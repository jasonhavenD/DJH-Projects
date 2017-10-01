KindEditor.ready(function (K) {
    K.create('textarea[name=content]', {/*css元素*/
        width: '800px',
        height: '200px',
        uploadJson: '/admin/upload/kindeditor',/*请求url*/
    });
});