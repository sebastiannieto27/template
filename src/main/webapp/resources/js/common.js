function handleSubmit(xhr, status, args, dialog) {
	var jqDialog = jQuery('#' + dialog.id);
	if (args.validationFailed) {
		jqDialog.effect('shake', {
			times : 3
		}, 100);
	} else {
		dialog.hide();
	}
}
function fixPFMDialogs() {
	jQuery("body > div[data-role='page']").each(
			function(i) {
				var pageId = jQuery(this).attr("id");
				jQuery("body > div[id*='" + pageId + "'][class*='ui-popup']")
						.appendTo("#" + pageId);
			});
}

PrimeFaces.locales['es'] = {
        closeText: 'cerrar',
        prevText: 'prev',
        nextText: 'sig',
        currentText: 'hoy',
        monthNames: ['Enero','Febrero','Marzo','Abril','Mayo','Junio',
            'Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
        monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun',
            'Jul','Ago','Sep','Oct','Nov','Dic'],
        dayNames: ['Domingo','Lunes','Martes','Miercoles','Jueves','Viernes','Sábado'],
        dayNamesShort: ['Dom','Lun','Mar','Mie','Jue','Vie','Sab'],
        dayNamesMin: ['Pz','Pt','Sa','Ça','Pe','Cu','Ct'],
        weekHeader: 'Hf',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: '',
        month: 'Mes',
        week: 'Semana',
        day: 'Día',
        allDayText : 'Todo el Día'
    };