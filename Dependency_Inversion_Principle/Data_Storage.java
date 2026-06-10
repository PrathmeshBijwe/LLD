// ❌ Wrong Approach
/*
class FileStorage {
    public void save(String data) {
        System.out.println("Saved to file: " + data);
    }
}

class ReportService {
    private FileStorage storage = new FileStorage();

    public void generateReport(String data) {
        storage.save(data);
    }
}
*/

// ✅ Correct Approach
interface Storage {
    void save(String data);
}

class FileStorage implements Storage {
    public void save(String data) {
        System.out.println("Saved to file: " + data);
    }
}

class DatabaseStorage implements Storage {
    public void save(String data) {
        System.out.println("Saved to database: " + data);
    }
}

class ReportService {
    private Storage storage;

    public ReportService(Storage storage) {
        this.storage = storage;
    }

    public void generateReport(String data) {
        storage.save(data);
    }
}
