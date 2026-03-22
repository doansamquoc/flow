import type { Navigation } from "@/features/auth/types/navigation";
import { LayoutDashboard, Settings } from "lucide-react";

export const navigations: Navigation[] = [
  {
    label: "Bảng điều khiển",
    icon: <LayoutDashboard size={20} />,
    path: "/dashboard",
  },

  {
    label: "Cài đặt",
    icon: <Settings size={20} />,
    path: "/dashboard/setting",
  },
];
