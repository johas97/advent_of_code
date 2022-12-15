import java.util.*;

public class FolderClass {

  private HashMap<String, Integer> files = new HashMap<>();
  private HashMap<String, FolderClass> folders_in_folder = new HashMap<>();
  private FolderClass parent_folder = null;

  private int cullmative_size;
  private String folder_name;
  private Boolean visited = false;

  public FolderClass(String folder_name, FolderClass parent_folder) {
    this.folder_name = folder_name;
    this.parent_folder = parent_folder;
  }

  public void addFile(String file_name, Integer file_size) {
    files.put(file_name, file_size);
    cullmative_size += file_size;
    if (parent_folder != null) {
      parent_folder.addSubfile(file_size);
    }
  }

  private void addSubfile(int subfile_size) {
    if (this.parent_folder != null) {
      parent_folder.addSubfile(subfile_size);
    }
    cullmative_size += subfile_size;
  }

  public void addFolder(String folder_name) {
    FolderClass sub_folder = new FolderClass(folder_name, this);
    folders_in_folder.put(folder_name, sub_folder);
  }

  public FolderClass getParent() {
    return this.parent_folder;
  }

  public FolderClass getFolder(String folder_name) {
    return folders_in_folder.get(folder_name);
  }

  public String getName() {
    return this.folder_name;
  }

  public Integer getCullmativeSize() {
    return this.cullmative_size;
  }

  public Integer bfs(int space_to_erase) {
    int advent_of_code_answer = 999999999;
    Queue<FolderClass> q_bfs = new LinkedList<>();
    if (this.cullmative_size <= 100000) {
      advent_of_code_answer += this.cullmative_size;
    }
    q_bfs.add(this);
    this.visited = true;

    // Lägg inn alla subfolders i kö

    while (!q_bfs.isEmpty()) {
      FolderClass bfs_folder = q_bfs.poll();
      System.out.println(bfs_folder.folder_name);

      System.out.println(bfs_folder.cullmative_size);
      if (
        bfs_folder.cullmative_size >= space_to_erase &&
        bfs_folder.cullmative_size < advent_of_code_answer
      ) {
        advent_of_code_answer = bfs_folder.cullmative_size;
      }
      for (Map.Entry<String, FolderClass> e : bfs_folder.folders_in_folder.entrySet()) {
        if (!e.getValue().visited) {
          q_bfs.add(e.getValue());
          e.getValue().visited = true;
        }
      }
    }

    return advent_of_code_answer;
  }

  public void printData() {
    System.out.print("name: ");
    System.out.println(folder_name);
    System.out.print("files: ");
    System.out.println(files);
    System.out.print("folders_in_folders: ");
    System.out.println(folders_in_folder);
    System.out.print("parent_folder: ");
    System.out.println(parent_folder);
    System.out.print("Cullmative size: ");
    System.out.println(cullmative_size);
    System.out.println("end of print");

    System.out.println(" ");
  }
}
