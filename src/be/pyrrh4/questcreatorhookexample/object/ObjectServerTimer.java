package be.pyrrh4.questcreatorhookexample.object;

import org.bukkit.Bukkit;

import be.pyrrh4.core.storage.YMLConfiguration;
import be.pyrrh4.questcreator.editor.util.EditorGUI;
import be.pyrrh4.questcreator.quest.ActiveQuestBranch;
import be.pyrrh4.questcreator.quest.Quest;
import be.pyrrh4.questcreator.quest.QuestBranch;
import be.pyrrh4.questcreator.quest.QuestModel;
import be.pyrrh4.questcreator.quest.object.AbstractTimerQuestObject;
import be.pyrrh4.questcreator.quest.object.ObjectProgression;
import be.pyrrh4.questcreator.quest.object.QuestObject;
import be.pyrrh4.questcreator.util.LoadResult;
import be.pyrrh4.questcreatorhookexample.Main;

public class ObjectServerTimer extends AbstractTimerQuestObject {

	public ObjectServerTimer(String id) {
		super(id, Main.serverTimerType);
	}

	@Override
	public void loadSettings(YMLConfiguration config, String path, boolean loadGoto, LoadResult<QuestObject> result) {
		super.loadSettings(config, path, loadGoto, result);
		// load settings here
	}

	@Override
	public void saveSettings(YMLConfiguration config, String path) {
		super.saveSettings(config, path);
		// save settings here
	}

	@Override
	public int addEditorIcons(QuestModel model, QuestBranch branch, EditorGUI gui, int slot) {
		// increment slot if you add icons, and then return it
		return slot;
	}

	@Override
	public void initialize(Quest quest, ActiveQuestBranch branch, ObjectProgression progress) {
		// you can eventually change the progress goal here, or other things
	}

	@Override
	protected Result progressInner(Quest quest, ActiveQuestBranch activeBranch, ObjectProgression progress) {
		Bukkit.getLogger().info("Log : progressing object " + getType().getId());
		// change "progress" if there's progress
		// return Result.PROGRESS or Result.COMPLETE eventually
		return Result.NONE;
	}

}
