package me.naphy.boxpvpcore;

import me.naphy.boxpvpcore.Inventories.Cobweb;
import org.bukkit.Bukkit;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static me.naphy.boxpvpcore.BoxPvpCore.plugin;

public class Scheduler {

    static Runnable runnable = new Runnable() {

        @Override
        public void run() {
            try {
                for (Cobweb.CobwebInfo cobweb : Cobweb.cobwebs) {
                    if (cobweb.cobwebTimer <= 0) {
                        Bukkit.getScheduler().runTask(plugin, () -> cobweb.cobwebLoc.getBlock().setType(Material.AIR));
                        if (Cobweb.cobwebs.size() <= 1) {
                            Cobweb.cobwebs = new ArrayList<>();
                        }
                        else {
                            Cobweb.cobwebs.remove(cobweb);
                        }
                    }
                    else {
                        cobweb.cobwebTimer--;
                    }
                }
            } catch (Exception e) {
                //System.err.println(e);
            }
        }
    };

    static ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    public static void start() {
        service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
    }

    public static void stop() {
        service.shutdownNow();
    }
}
