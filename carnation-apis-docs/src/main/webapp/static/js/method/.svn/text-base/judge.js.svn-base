KISSY.ready(function (S) {
	/**
	 * 搜索按钮状态改变
	 *
	**/
	var S = KISSY, DOM = S.DOM, Event = S.Event;
	var apiList = DOM.query('.api-list'), searchInput = DOM.get('.searchInput'), searchBtn = DOM.get('#searchBtn');
	apiList && S.each(apiList , function(list) {
		Event.on(list, 'mouseover', function(e) {
			DOM.addClass(this, 'hover-list');
		});
		Event.on(list, 'mouseout', function(e) {
			DOM.removeClass(this, 'hover-list');
		});
	});
	searchInput && Event.on(searchInput, 'focus', function(e) {
		DOM.css(searchBtn, 'background-position', '0px -73px');
	});
	searchInput && Event.on(searchInput, 'blur', function(e) {
		DOM.css(searchBtn, 'background-position', '0px 0px');
	});
	
	/**
	 * 动态收展树状菜单
	 *
	**/
		var tree = S.one('.level-one'), levelone = S.all('.first', tree), leveltwo = S.all('.second', tree);
		levelone && S.each(levelone, function(item) {
			var parent = DOM.parent(item, 'li'), nextlevel = S.all('.level-two', parent), isShow = nextlevel && S.DOM.hasClass(nextlevel, 'category-hide');
			if(isShow) {
				S.one(item).addClass('hasSub');
			}
			S.one(item).on('click', function() {
				isShow = nextlevel && S.DOM.hasClass(nextlevel, 'category-hide');
				if(isShow) {
					S.one(this).removeClass('hasSub');
					S.one(this).addClass('showSub');
					S.one('ul', parent) && S.one('ul', parent).removeClass('category-hide');
					S.one(parent).addClass('selected');
				}else{
					if(!!S.one('ul', parent)) {
						S.one('ul', parent).addClass('category-hide');
						S.one(parent).removeClass('selected');
						S.one(this).removeClass('showSub');
						S.one(this).addClass('hasSub');
					}
				}
			});
		});
		leveltwo && S.each(leveltwo, function(item) {
			var parent = DOM.parent(item, 'li'), nextlevel = S.all('.level-three', parent), isShow = nextlevel && S.DOM.hasClass(nextlevel, 'category-hide');
			if(isShow) {
				S.one(item).addClass('hasSub');
			}
			S.one(item).on('click', function() {
				isShow = nextlevel && S.DOM.hasClass(nextlevel, 'category-hide');
				if(isShow) {
					S.one(this).removeClass('hasSub');
					S.one(this).addClass('showSub');
					S.one('ul', parent) && S.one('ul', parent).removeClass('category-hide');
					S.one(parent).addClass('selected');
				}else {
					if(!!S.one('ul', parent)) {
							S.one('ul', parent).addClass('category-hide');
							S.one(parent).removeClass('selected');
							S.one(this).removeClass('showSub');
							S.one(this).addClass('hasSub');
						}
				}
			});
		});
	
	/**
	 * 隐藏搜索按钮
	 *
	**/
	var search = S.one('#searchSelect') ,q = S.one('#q'), api = S.one('#api-search-input');
	search && search.on("change", function(e) {
		if(S.one(this).val() == 'API') {
			window.isDefault = true;
			searchBtn && DOM.css(searchBtn, 'display', 'none');
			q && DOM.css(q, 'display', 'none');
			api && DOM.css(api, 'display', 'block');
			DOM.val(api, '请点击搜索下拉提示列表项');
      }
      else {
			searchBtn && DOM.css(searchBtn, 'display', 'block');
			q && DOM.css(q, 'display', 'block');
			api && DOM.css(api, 'display', 'none');
      }
   });
   
    api && api.on('focus', function(){
		if(window.isDefault){
			DOM.val(api, '');
		}
   });
	
	
	/**
	  *api_detail目录链接跳转
	  *
	 **/
	  var APIgory = DOM.query('div.APIgory-list');
	  if(!APIgory){ return ;}
	  S.each(APIgory, function(el) {
		if(DOM.get('s', el)){
			var url = DOM.attr(DOM.get('a', el), 'href');
			Event.on(el, 'click', function(){
				window.location = url;
			});
		}
	  });
});