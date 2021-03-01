<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <html>
            <head>
                <meta charset="UTF-8"/>
                <title>Жанры</title>
            </head>
            <body>
                <div class="header">
                    <div class="header-link">
                        <a href="/">Главная страница</a>
                    </div>
                    <div class="header-link current-link">
                        <a href="/xml/authors">Авторы</a>
                    </div>
                    <div class="header-link">
                        <a href="/xml/books">Книги</a>
                    </div>
                    <div>
                        <a href="/xml/genres">Жанры</a>
                    </div>
                </div>
                <table border="1" style="margin-top: 5px">
                    <tr bgcolor="#CCCCCC">
                        <td><strong>Id</strong></td>
                        <td><strong>Название</strong></td>
                    </tr>
                    <xsl:for-each select="ArrayList/item">
                        <tr>
                            <td><xsl:value-of select="id"/></td>
                            <td><xsl:value-of select="name"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
