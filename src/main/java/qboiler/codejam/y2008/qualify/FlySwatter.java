package qboiler.codejam.y2008.qualify;

import java.text.DecimalFormat;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author qboiler
 */
public class FlySwatter extends Thread {

    private final double flyRadius;
    private final double racketRadius;
    private final double racketThickness;
    private final double stringRadius;
    private final double stringGap;
    private final int caseNumbert;

    private FlySwatter(int caseNumber,
                       double f,
                       double R,
                       double t,
                       double r,
                       double g) {

        //f, R, t, r and g
        flyRadius = f;
        racketRadius = R;
        racketThickness = t;
        stringRadius = r;
        stringGap = g;
        caseNumbert = caseNumber;

    }

    private String result = "";
    private final Double EPSILON = 0.00000004;
    private final DecimalFormat df2 = new DecimalFormat("#0.000000");
    private final Random r = new Random();
    private final Random r2 = new Random();

    public void run(){
        try {
            processCase();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(FlySwatter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private final ThreadPoolExecutor e = new ThreadPoolExecutor(10, 10, 5, TimeUnit.DAYS, new ArrayBlockingQueue<>(100));
    
    
    private void processCase() throws InterruptedException, ExecutionException {

        final AtomicLong hits = new AtomicLong(0);
        final AtomicLong total = new AtomicLong(0);

        double percent = 1;
        double delta;
        int c = 0;
        do {
            ++c;
            Queue<Future> fQueue = new  ArrayBlockingQueue<>(100);
            for(int j=0;j<c;++j){
            Future f = e.submit(() -> {
        for (int i = 0; i < 10000000; ++i) {
            total.incrementAndGet();
            if (monteCarloTest()) {
                hits.incrementAndGet();
            }
        }
            });
            fQueue.add(f);
            }
            while(!fQueue.isEmpty()){
                Future f = fQueue.poll();
                f.get();
            }
            
            double t = hits.doubleValue() / total.doubleValue();
            delta = Math.abs(t - percent);
            percent = t;
        } while (delta > EPSILON);
        result = String.valueOf(df2.format(percent));
        System.out.println("Case #" + caseNumbert + ": " + result);
        e.shutdownNow();
    }

    private boolean monteCarloTest() {
            //boolean hitRacket = false;

        double drand = r.nextDouble();
        double drand2 = r2.nextDouble();
        double pathRadius = Math.sqrt(drand) * racketRadius;
        double pathAngle = drand2 * (Math.PI / 2.0);
        if (pathRadius >= racketRadius - racketThickness - flyRadius) {
            return true;
        } else {
            double pitch = 2.0d * stringRadius + stringGap;// - 2*stringRadius;
            if (2 * flyRadius > stringGap) {
                return true;
            }
            // Convert to cartesian coordinates and try...
            double x = Math.cos(pathAngle) * pathRadius;
            double y = Math.sin(pathAngle) * pathRadius;

            double minX = x - flyRadius;
            double maxX = x + flyRadius;
            double minY = y - flyRadius;
            double maxY = y + flyRadius;

            int leftX = (int) (minX / pitch);
            int rightX = (int) (maxX / pitch);
            int bottomY = (int) (minY / pitch);
            int topY = (int) (maxY / pitch);
            if (leftX != rightX || bottomY != topY) {
                return true;
            }

            double leftStringEdge
                    = pitch * leftX + stringRadius;
            if (leftStringEdge >= minX) {
                return true;
            }

            double rightStringEdge
                    = pitch * (leftX + 1) - stringRadius;
            assert (rightStringEdge - leftStringEdge - stringGap) < EPSILON;
            if (rightStringEdge <= maxX) {
                return true;
            }

            double bottomStringEdge
                    = pitch * bottomY + stringRadius;
            if (bottomStringEdge >= minY) {
                return true;

            }

            double topStringEdge
                    = pitch * (bottomY + 1) - stringRadius;
            // Confirm the Top String's Bottom Edge is the same via both calcs...
            assert (topStringEdge - bottomStringEdge - stringGap) < EPSILON;
            return topStringEdge <= maxY;

        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
       new FlySwatter(1, 0.25, 1.0, 0.1, 0.01, 0.5).processCase();
        new FlySwatter(2, 0.25, 1.0, 0.1, 0.01, 0.9).processCase();
       new FlySwatter(3, 0.00001, 10000, 0.00001, 0.00001, 1000).processCase();
        new FlySwatter(4, 0.4, 10000, 0.00001, 0.00001, 700).processCase();
        new FlySwatter(5, 1, 100, 1, 1, 10).processCase();
            }
}
