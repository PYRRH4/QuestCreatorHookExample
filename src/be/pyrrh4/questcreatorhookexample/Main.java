package be.pyrrh4.questcreatorhookexample;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.plugin.java.JavaPlugin;

import be.pyrrh4.questcreator.QuestCreator;
import be.pyrrh4.questcreator.model.object.QObjectType;
import be.pyrrh4.questcreator.model.object.QObjectType.Category;
import be.pyrrh4.questcreatorhookexample.object.ObjectPlayerBucket;
import be.pyrrh4.questcreatorhookexample.object.ObjectServerTimer;

public class Main extends JavaPlugin implements Listener {

	public static QObjectType objectBucketType = null;
	public static QObjectType serverTimerType = null;

	@Override
	public void onEnable() {
		// register the new types
		objectBucketType = QObjectType.registerType("PLAYER_NEWBUCKETFILL", ObjectPlayerBucket.class, Category.PLAYER);
		serverTimerType = QObjectType.registerType("SERVER_NEWTIMER", ObjectServerTimer.class, Category.SERVER);
		// register events
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	// on event, calling the quest manager event checker (for our PLAYER_NEWBUCKETFILL object)
	@EventHandler
	public void event(PlayerBucketFillEvent event) {
		QuestCreator.inst().getQuestManager().check(event);
	}

}
