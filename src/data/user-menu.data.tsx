import type { MenuGroup } from "@/features/auth/types/menu-grou.type";
import {
  CreditCard,
  LogOut,
  PiggyBank,
  UserCircle,
  WalletCards,
} from "lucide-react";

export const userMenus: MenuGroup[] = [
  {
    label: "Tài khoản",
    items: [
      {
        label: "Hồ sơ",
        icon: <UserCircle />,
        type: "navigate",
        payload: "/profile",
        isDestructive: false,
      },
    ],
  },
  {
    label: "Ví điện tử",
    items: [
      {
        label: "Ví",
        icon: <WalletCards />,
        type: "action",
        payload: "wallet",
        isDestructive: false,
      },
      {
        label: "Số dư",
        icon: <PiggyBank />,
        type: "action",
        payload: "balance",
        isDestructive: false,
      },
      {
        label: "Địa chỉ ví",
        icon: <CreditCard />,
        type: "action",
        payload: "address",
        isDestructive: false,
      },
    ],
  },
  {
    items: [
      {
        label: "Đăng xuất",
        icon: <LogOut />,
        type: "action",
        payload: "logout",
        isDestructive: true,
      },
    ],
  },
];
