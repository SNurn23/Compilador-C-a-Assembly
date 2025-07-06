package Analizador;

import java.io.File;

public class Script {
    private final String programaCppPath;
    private final String programaIPath;
    private final String programaOPath;
    private final String programaPath;
    private final String programaSPath;
    private final String projectPath;
    private String path; // Variable para los métodos get/set, necesaria para btnArchivo

    public Script(String compilerPath) {
        // La variable compilerPath no se usa actualmente, pero la mantenemos por si se necesita
        this.projectPath = new File("src/Archivos/").getAbsolutePath();
        this.programaCppPath = new File("src/Archivos/Programa.cpp").getAbsolutePath();
        this.programaIPath = new File("src/Archivos/Programa.i").getAbsolutePath();
        this.programaOPath = new File("src/Archivos/Programa.o").getAbsolutePath();
        this.programaPath = new File("src/Archivos/Programa.exe").getAbsolutePath();
        this.programaSPath = new File("src/Archivos/Programa.s").getAbsolutePath();
    }

    /**
     * Método base para ejecutar un script en la consola.
     * @param script El comando a ejecutar.
     * @param conPausa Si es true, la consola esperará a que el usuario presione una tecla.
     */
    private boolean bat(String script, boolean conPausa) {
        String finalScript = "cmd /c start cmd.exe /K \"cd " + projectPath + " && " + script;
        if (conPausa) {
            finalScript += " && pause && exit\"";
        } else {
            finalScript += " && exit\"";
        }

        System.out.println("Ejecutando: " + finalScript);
        try {
            Runtime.getRuntime().exec(finalScript);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // --- MÉTODOS RESTAURADOS ---
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public boolean addPath(){
        if(this.path == null || this.path.trim().isEmpty()){
            return false;
        }
        return bat("set path=%path%;"+this.path, false);
    }
    // --- FIN DE MÉTODOS RESTAURADOS ---
    
    
    // Los pasos de compilación se ejecutan SIN PAUSA para que sean rápidos.
    public boolean intermedio() {
        return bat("cpp Programa.cpp > Programa.i", false);
    }
    
    public boolean assambler() {
        return bat("g++ -Wall -S Programa.i", false);
    }
    
    public boolean objeto() {
        return bat("as " + "\"" + programaSPath + "\"" + " -o " + "\"" + programaOPath + "\"", false);
    }
    
    public boolean ejecutable() {
        return bat("g++ " + "\"" + programaOPath + "\"" + " -o " + "\"" + programaPath + "\"", false);
    }
    
    // La ejecución del programa final se realiza CON PAUSA para poder ver el resultado.
    public boolean start() {
        return bat("\"" + programaPath + "\"", true);
    }
}