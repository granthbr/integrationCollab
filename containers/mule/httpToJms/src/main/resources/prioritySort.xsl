<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">
	<!-- <xsl:output method="text" /> -->
	<xsl:template match="root/events">
		<xsl:copy>
			<xsl:apply-templates>
				<xsl:sort select="date_finish_value"/>
				<xsl:sort select="sort_order" data-type="number" />
			</xsl:apply-templates>
		</xsl:copy>
	</xsl:template>
	<xsl:template match="*">
		<xsl:copy>
			<xsl:apply-templates />
		</xsl:copy>
	</xsl:template>
</xsl:stylesheet>