<input type="button" value="Ga terug" onclick="history.back();" />
<input type="submit"
		onclick="location.href='${pageContext.request.contextPath}/relatiebeheer/organisaties/zoeken'"
		value="zoekscherm" />
</br>
</br>

${succes}

</br>
</br>
</br>
<p>
	<input type="submit"
		onclick="location.href='${pageContext.request.contextPath}/relatiebeheer/organisaties/nieuwAdres-${bedrijfDTO.bedrijf.id}'"
		value="Adres toevoegen" />
</p>
<p>
	<input type="submit"
		onclick="location.href='${pageContext.request.contextPath}/relatiebeheer/organisaties/nieuwContactpersoon-${bedrijfDTO.bedrijf.id}'"
		value="Nieuw persoon toevoegen" />
</p>
<p>
	<input type="submit"
		onclick="location.href='${pageContext.request.contextPath}/relatiebeheer/organisaties/zoekContactpersoon-${bedrijfDTO.bedrijf.id}'"
		value="Bestaand persoon toevoegen" />
</p>


