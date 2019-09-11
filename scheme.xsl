<?xml version="1.0" encoding="UTF-8" ?>
<xsl-stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output indent="yes"/>

    <xsl:template match="/">
        <entries>
            <xsl:for-each select="entries/entry">
                <xsl:sort data-type="number" order="descending" select="field" />
                <entry>
                    <xsl:attribute name="href">
                        <xsl:value-of select="field"/>
                    </xsl:attribute>
                </entry>
            </xsl:for-each>
        </entries>
    </xsl:template>
</xsl-stylesheet>

