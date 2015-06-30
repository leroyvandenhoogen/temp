<input type="button" value="Ga terug" onclick="history.back();" />
</br>
</br>
${succes}

<p>
	<input type="submit"
		onclick="location.href='${pageContext.request.contextPath}/relatiebeheer/personen/nieuwadres-${persoonDTO.persoon.id}'"
		value="Nog een adres toevoegen" />
</p>
<p>
	<input type="submit"
		onclick="location.href='${pageContext.request.contextPath}/relatiebeheer/personen/nieuwpersoonsrol-${persoonDTO.persoon.id}'"
		value="Persoonsrol toevoegen" />
</p>
