package be.pyrrh4.questcreatorhookexample.object;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerBucketFillEvent;

import be.pyrrh4.questcreator.QCLocale;
import be.pyrrh4.questcreator.data.Quest;
import be.pyrrh4.questcreator.loadable.Loadable;
import be.pyrrh4.questcreator.loadable.setting.SettingInteger;
import be.pyrrh4.questcreator.model.object.AbstractEventQuestObject;
import be.pyrrh4.questcreator.quest.BranchProgression;
import be.pyrrh4.questcreator.quest.ObjectProgression;
import be.pyrrh4.questcreatorhookexample.Main;

public class ObjectPlayerBucket extends AbstractEventQuestObject<PlayerBucketFillEvent> {

	public ObjectPlayerBucket(Loadable<?> parent, String id) {
		super(parent, id, Main.objectBucketType, PlayerBucketFillEvent.class);
		// add settings here, for example we'll add an amount of times ; loading, saving and editor generation is done automatically !
		registerSetting(new SettingInteger("amount", "1", false, QCLocale.GUI_QUESTCREATOR_EDITOR_GENERIC_AMOUNTLORE.getLines()));
	}

	@Override
	public void initialize(Quest quest, BranchProgression branch, ObjectProgression progress) {
		// you can change the progress goal here, or other things
		// here we'll initialize the object goal, so we'll parse our "amount" setting for the quest leader - the goal won't change until the object is done
		progress.setGoal(getSettingInteger("amount").getParsed(quest.getLeader().getPlayer()));
	}

	@Override
	protected CallResult progressInner(Quest quest, BranchProgression activeBranch, ObjectProgression progress, PlayerBucketFillEvent event, Player player) {
		// update the progression
		progress.alterCurrent(1D);
		return progress.isComplete() ? CallResult.COMPLETE : CallResult.PROGRESS;
	}

}
