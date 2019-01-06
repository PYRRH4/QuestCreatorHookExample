package be.pyrrh4.questcreatorhookexample.object;

import org.bukkit.Bukkit;

import be.pyrrh4.questcreator.data.Quest;
import be.pyrrh4.questcreator.loadable.Loadable;
import be.pyrrh4.questcreator.model.object.AbstractTimerQuestObject;
import be.pyrrh4.questcreator.quest.BranchProgression;
import be.pyrrh4.questcreator.quest.ObjectProgression;
import be.pyrrh4.questcreatorhookexample.Main;

public class ObjectServerTimer extends AbstractTimerQuestObject {

	public ObjectServerTimer(Loadable<?> parent, String id) {
		super(parent, id, Main.serverTimerType);
		// register settings here
	}

	@Override
	public void initialize(Quest quest, BranchProgression branch, ObjectProgression progress) {
		// you can eventually change the progress goal here, or other things
	}

	@Override
	protected CallResult progressInner(Quest quest, BranchProgression activeBranch, ObjectProgression progress) {
		Bukkit.getLogger().info("Log : progressing object " + getType().getId());
		// change "progress" if there's progress
		// return Result.PROGRESS or Result.COMPLETE eventually
		return CallResult.NONE;
	}

}
