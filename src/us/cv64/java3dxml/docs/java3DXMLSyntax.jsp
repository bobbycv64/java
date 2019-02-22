<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta http-equiv="content-type"
 content="text/html; charset=ISO-8859-1">
  <title>Java3DXML Syntax</title>
</head>
<body>
<small style="font-family: helvetica,arial,sans-serif;"><big><span
 style="font-weight: bold;">Java3DXML
Syntax</span></big><br>
<br>
</small>
<table cellpadding="2" cellspacing="2" border="1"
 style="text-align: left; font-family: helvetica,arial,sans-serif; height: 480px; width: 909px;">
  <tbody>
    <tr>
      <td style="vertical-align: top;"><small>Java3DXML Element<br>
      </small></td>
      <td style="vertical-align: top;"><small>Description<br>
      </small></td>
      <td style="vertical-align: top;"><small>Cardinality<br>
      </small></td>
    </tr>
    <tr>
      <td style="vertical-align: top;"><small>&lt;<a name="universe"></a>universe&gt;</small></td>
      <td style="vertical-align: top;"><small>The entire universe to
render.</small></td>
      <td style="vertical-align: top;"><small>1..1<br>
      </small></td>
    </tr>
    <tr>
      <td style="vertical-align: top;"><small>&lt;<a name="camera"></a>camera&gt;</small></td>
      <td style="vertical-align: top;"><small>Synthetic camera,
location of the eye.<br>
&nbsp; <span style="font-weight: bold;">Note:</span>&nbsp; Requires <a
 href="#color">color</a> element.<br>
      </small></td>
      <td style="vertical-align: top;"><small>1..1<br>
      </small></td>
    </tr>
    <tr>
      <td style="vertical-align: top;"><small>&lt;<a name="lights"></a>lights&gt;<br>
      </small></td>
      <td style="vertical-align: top;"><small>Encapsulation of all
light sources.</small><br>
      </td>
      <td style="vertical-align: top;"><small>1..M<br>
      </small></td>
    </tr>
    <tr>
      <td style="vertical-align: top;"><small>&lt;<a name="light"></a>light
name="name of light"&gt;<br>
      </small></td>
      <td style="vertical-align: top;"><small>Light source.<br>
      </small><small>&nbsp; <span style="font-weight: bold;">Note:</span>&nbsp;
Requires <a
 href="file:///C:/Documents%20and%20Settings/Daddy/Desktop/Java3DXMLSyntax.html#color">color</a>
and <a href="#translate">translate</a> elements.</small><br>
      </td>
      <td style="vertical-align: top;"><small>1..1<br>
      </small></td>
    </tr>
    <tr>
      <td style="vertical-align: top;"><small>&lt;<a name="scene"></a>scene&gt;<br>
      </small></td>
      <td style="vertical-align: top;"><small>Encapsulation of all
objects.<br>
      </small></td>
      <td style="vertical-align: top;"><small>1..1<br>
      </small></td>
    </tr>
    <tr>
      <td style="vertical-align: top;"><small>&lt;<a name="xyz"></a>xyz
      <br>
&nbsp; name="name of coordinate System"&gt;<br>
      <br>
or<br>
      <br>
&lt;coordinateSystem <br>
&nbsp; name="name of coordinate System"&gt;<br>
      </small></td>
      <td style="vertical-align: top;"><small>Encapsulation of a
separate coordinate system.&nbsp; Element can be either xyz or
coordinateSystem.<br>
      <br>
      <a href="#translate">Translate</a>, <a href="#scale">scale</a>, <a
 href="#rotate">rotate</a> and <a href="#shere">shere</a> elements can
also be used.&nbsp; Default coordinate (0,0,0).<br>
      </small></td>
      <td style="vertical-align: top;"><small>1..M<br>
      </small></td>
    </tr>
    <tr>
      <td style="vertical-align: top;"><small>&lt;<a name="object"></a>object
name="name of object"&gt;<br>
      </small></td>
      <td style="vertical-align: top;"><small>&nbsp; <span
 style="font-weight: bold;">Note:</span>&nbsp;
Requires at least one of the following objects, all attributes are
double..</small>
      <table cellpadding="2" cellspacing="2" border="0"
 style="text-align: left; width: 100%;">
        <tbody>
          <tr>
            <td style="vertical-align: top;"><small>cone<br>
            </small></td>
            <td style="vertical-align: top;"><small>&lt;cone
diameter="size" height="size"&gt;<br>
            </small></td>
          </tr>
          <tr>
            <td style="vertical-align: top;"><small>cube<br>
            </small></td>
            <td style="vertical-align: top;"><small>&lt;cube
length="size", width="size", height="size"&gt;<br>
            </small></td>
          </tr>
          <tr>
            <td style="vertical-align: top;"><small>cylinder<br>
            </small></td>
            <td style="vertical-align: top;"><small>&lt;cylinder
diameter="size" height="size"&gt;</small></td>
          </tr>
          <tr>
            <td style="vertical-align: top;"><small>sphere<br>
            </small></td>
            <td style="vertical-align: top;"><small>&lt;sphere
diameter="size"&gt;<br>
            </small></td>
          </tr>
        </tbody>
      </table>
      <small>&nbsp; <span style="font-weight: bold;">Note:</span>&nbsp;
All require <a
 href="file:///C:/Documents%20and%20Settings/Daddy/Desktop/Java3DXMLSyntax.html#color">color</a>
and <a
 href="file:///C:/Documents%20and%20Settings/Daddy/Desktop/Java3DXMLSyntax.html#translate">translate</a>
elements.&nbsp; <a href="#scale">Scale</a>, <a href="#rotate">rotate</a>
and <a href="#shere">shere</a> optional.</small> </td>
      <td style="vertical-align: top;"><small>1..M<br>
      </small></td>
    </tr>
    <tr>
      <td style="vertical-align: top;"><small>&lt;<a name="color"></a>color
red="0", green="0", blue="0" /&gt;<br>
      </small></td>
      <td style="vertical-align: top;"><small>Color of object, 3
integer attributes:&nbsp; red, green and blue, values range from 0
(black) to
255 (white).<br>
      </small></td>
      <td style="vertical-align: top;"><small>1..1<br>
      </small></td>
    </tr>
    <tr>
      <td style="vertical-align: top;"><small>&lt;<a name="translate"></a>translate
x="0" y="0" z="0" /&gt;</small></td>
      <td style="vertical-align: top;"><small>Translates object, 3
double attributes:&nbsp; x-axis, y-axis, z-axis, values range from 0.0</small><small>
and up</small></td>
      <td style="vertical-align: top;"><small>1..1<br>
      </small></td>
    </tr>
    <tr>
      <td style="vertical-align: top;"><small>&lt;<a name="scale"></a>scale
x="0" y="0" z="0" /&gt;</small></td>
      <td style="vertical-align: top;"><small>Scales object</small><small>,
3 double attributes:&nbsp; x-axis, y-axis, z-axis, values range from 0.0</small><small>
and up</small></td>
      <td style="vertical-align: top;"><small>1..1<br>
      </small></td>
    </tr>
    <tr>
      <td style="vertical-align: top;"><small>&lt;<a name="rotate"></a>rotate
x="0" y="0" z="0" /&gt;</small></td>
      <td style="vertical-align: top;"><small>Rotates object</small><small>,
3 double attributes:&nbsp; x-axis, y-axis, z-axis, values range from 0.0</small><small>
and up</small></td>
      <td style="vertical-align: top;"><small>1..1<br>
      </small></td>
    </tr>
    <tr>
      <td style="vertical-align: top;"><small>&lt;<a name="shere"></a>shere
x="0" y="0" z="0" /&gt;</small></td>
      <td style="vertical-align: top;"><small>Sheres object</small><small>,
3 double attributes:&nbsp; x-axis, y-axis, z-axis, values range from
0.0 and up<br>
      </small></td>
      <td style="vertical-align: top;"><small>1..1<br>
      </small></td>
    </tr>
  </tbody>
</table>
<br style="font-family: helvetica,arial,sans-serif;">
<a href="syntaxExample.xml"
 style="font-family: helvetica,arial,sans-serif;">Syntax Example</a><br
 style="font-family: helvetica,arial,sans-serif;">
<jsp:include page="../legal/copyright.jsp">
</jsp:include>
</body>
</html>
