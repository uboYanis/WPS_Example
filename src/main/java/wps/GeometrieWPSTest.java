package wps;

import org.geoserver.wps.gs.GeoServerProcess;
import org.geotools.process.factory.DescribeParameter;
import org.geotools.process.factory.DescribeProcess;
import org.geotools.process.factory.DescribeResult;
import org.geotools.process.factory.StaticMethodsProcessFactory;
import org.geotools.text.Text;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Polygon;

public class GeometrieWPSTest extends StaticMethodsProcessFactory<GeometrieWPSTest> implements GeoServerProcess {

	public GeometrieWPSTest() {
		super(Text.text("WPS Geometry test "), "geoTest", GeometrieWPSTest.class);
	}

	@DescribeProcess(title = "WPS getArea", description = "WPS area calcul")
	@DescribeResult(name = "Area of geometry", description = "the resulting gemitry area")
	public static double getArea(
			@DescribeParameter(name = "geometry", description = "input geometry") final Geometry inputGeometry) {

		double result = 0;
		if (inputGeometry instanceof Polygon) {
			GeometryFactory gf = new GeometryFactory();
			Polygon p = gf.createPolygon(inputGeometry.getCoordinates());
			result = p.getArea();
		}

		return result;
	}

	@DescribeProcess(title = "WPS getPrimeter", description = "WPS perimeter calcul")
	@DescribeResult(name = "Area of geometry", description = "the resulting geometry perimeter")
	public static double getPerimeter(
			@DescribeParameter(name = "geometry", description = "input geometry") final Geometry inputGeometry) {

		double result = 0;
		if (inputGeometry instanceof Polygon) {

			GeometryFactory gf = new GeometryFactory();
			Polygon p = gf.createPolygon(inputGeometry.getCoordinates());
			result = p.getLength();
		}

		if (inputGeometry instanceof LineString) {
			GeometryFactory gf = new GeometryFactory();
			LineString ls = gf.createLineString(inputGeometry.getCoordinates());
			result = ls.getLength();
		}

		return result;
	}

	@DescribeProcess(title = "WPS getPointNumber", description = "WPS number point calcul")
	@DescribeResult(name = "Area of geometry", description = "the resulting point number of geometry")
	public static double getPointNumber(
			@DescribeParameter(name = "geometry", description = "input geometry") final Geometry inputGeometry) {

		double result = 0;
		if (inputGeometry instanceof Polygon) {
			GeometryFactory gf = new GeometryFactory();
			Polygon p = gf.createPolygon(inputGeometry.getCoordinates());
			result = p.getNumPoints();
		}

		if (inputGeometry instanceof LineString) {
			GeometryFactory gf = new GeometryFactory();
			LineString ls = gf.createLineString(inputGeometry.getCoordinates());
			result = ls.getNumPoints();
		}

		return result;
	}

}