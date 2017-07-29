<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:alura="http://alura.com.br">

    <xsl:template match="/movimentacoes">
		<movimentacao:movimentacao>
	        <movimentacao:valor><xsl:value-of select="valor"/></movimentacao:valor>
	        <movimentacao:data><xsl:value-of select="data"/></movimentacao:data>
	        <movimentacao:tipo><xsl:value-of select="tipo"/></movimentacao:tipo>
        </movimentacao:movimentacao>    </xsl:template>
</xsl:stylesheet>