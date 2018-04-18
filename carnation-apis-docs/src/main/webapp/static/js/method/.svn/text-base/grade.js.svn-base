KISSY.ready(function(S) {
	var S = KISSY, DOM = S.DOM, Event = S.Event;
	
	var linkDiv = DOM.get('div.APIgory'), sublink = DOM.query('a.APIgoryItem', linkDiv), mask = DOM.query('s', linkDiv), menuTip = DOM.create('<div class="pop-tip hidden"></div>');
	document.body.appendChild(menuTip);
	if(!linkDiv){
		return;
	}
	mask && S.each(mask, function(item){
		Event.on(item, 'mouseover', function(e){
			var parent = DOM.prev(item, '.APIgory-content'), 
				text1 = DOM.text(DOM.get('a', parent)),
				text2 = DOM.text(DOM.get('p', parent));
			e.halt();
			var tar = e.target ;
		//	DOM.text(menuTip, text);
			menuTip.innerHTML = text1 + "<br/>" + text2;
			offset = DOM.offset(tar);
			DOM.css(menuTip, "left", offset.left+ DOM.width(tar)-70+"px");
			DOM.css(menuTip, "top", offset.top+44+"px");
			DOM.removeClass(menuTip, 'hidden');
		});
		Event.on(item, 'mouseout' , function(e) {
			DOM.addClass(menuTip, 'hidden');
		});
	});	
});