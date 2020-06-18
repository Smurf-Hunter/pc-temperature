package com.smurf.temperaturedekhlofraands.service;

import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.model.components.Gpu;
import com.profesorfalken.jsensors.model.sensors.Fan;
import com.profesorfalken.jsensors.model.sensors.Load;
import com.profesorfalken.jsensors.model.sensors.Temperature;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class MainService {


    List<Cpu> cpus ;
    List<Gpu> gpus ;

    public ModelAndView cpu(Components components){
        cpus = components.cpus;

        ModelAndView model = new ModelAndView("cpu");
        if(cpus!=null){
            for (final Cpu cpu : cpus) {
                List<Temperature> temperatures = cpu.sensors.temperatures;
                List<Fan> fans = cpu.sensors.fans;
                List<Load> loads = cpu.sensors.loads;
                model.addObject("cpuTemps", temperatures);
                model.addObject("cpuFans", fans);
                model.addObject("cpuLoads", loads);
            }
        }
        return model;
    }

    public ModelAndView gpu(Components components){
        gpus = components.gpus;
        ModelAndView model = new ModelAndView("gpu");

        if(gpus!=null){
            for(final Gpu gpu : gpus){
                List<Temperature> temperatures = gpu.sensors.temperatures;
                List<Fan> fans = gpu.sensors.fans;
                List<Load> loads = gpu.sensors.loads;
                model.addObject("gpuTemps", temperatures);
                model.addObject("gpuFans", fans);
                model.addObject("gpuLoads", loads);

            }
        }

        return model;
    }

    public ModelAndView main(Components components){
        ModelAndView model = new ModelAndView("main");
        cpus = components.cpus;
        gpus = components.gpus;
        if(cpus!=null){
            if(cpus.size()==0){
                model.addObject("cpu" , "Found no CPU");
            }else{
                for(final Cpu cpu: cpus){
                    model.addObject("cpu" , cpu.name);
                }
            }
        }else{
            model.addObject("cpu" , "Found no CPU");
        }
        if(gpus!=null){
            if(gpus.size()==0){
                model.addObject("gpu" , "Found no GPU");
            }else{
                for(final Gpu gpu:gpus){
                    model.addObject("gpu" , gpu.name);
                }
            }
        }else{
            model.addObject("gpu" , "Found no GPU");
        }
        return model;
    }



}
